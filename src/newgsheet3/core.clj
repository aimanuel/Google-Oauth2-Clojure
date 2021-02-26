(ns newgsheet3.core
     (:require [clj-time.core :as time]
             [google-apps-clj.credentials :as gauth]
             [google-apps-clj.google-drive :as gdrive]
             [google-apps-clj.google-drive.mime-types :as mime-types]
             [google-apps-clj.google-sheets-v4 :refer :all :as gsheets])
     (:import [com.google.api.services.sheets.v4.model CellData RowData]))


(def gcreds-no-token
  {:client-id "CLIENT ID"
   :client-secret "CLIENT SECRET"
   :redirect-uris ["urn:ietf:wg:oauth:2.0:oob" "http://localhost"]})


(def gcreds-w-token
  {:client-id "CLIENT ID"
   :client-secret "CLIENT SECRET"
   :redirect-uris ["urn:ietf:wg:oauth:2.0:oob" "http://localhost"]
   :auth-map {:access-token "ACCESS TOKEN"
              :expires-in 3599
              :refresh-token "REFRESH TOKEN"
              :token-type "Bearer"}})


(gauth/get-auth-map
 gcreds-no-token
 ["https://www.googleapis.com/auth/drive"
  "https://www.googleapis.com/auth/spreadsheets"])

(def services (gsheets/build-service gcreds-w-token))


(gsheets/get-spreadsheet-info services "SPREADSHEET-ID")

(gsheets/get-cell-values
 services
 "SPREADSHEET-ID"
 ["Sheet1!B9:B11"])
