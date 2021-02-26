# Google Oauth2 - Clojure

This is based on https://github.com/SparkFund/google-apps-clj see "Clojure_Connect_to_Google_APIs.pdf" for instruction with screenshot

	1. Follow the instruction from sparkFund
	2. Create credential from Google API Console https://console.developers.google.com/?pli=1 
		a. Select Credential tab > create credential > OAuth Client ID > Choose desktop app
		b. Download the json and open it to copy the client-id, client-secret, and redirect-uris
		c. Paste all that into gcreds-no-token
	3. Run (gauth/get-auth-map)
		a. Input the auth-code given from browser after accept the google sign-in, the code will be like
		4/1AY0e-g4ZJPsomecodenBK3VGi7igb0Up6QeGQ3JFwqpY
		b. Paste it in the emacs in Stdin: 4/1AY0e-g4ZJPeYwatUetLLy1rtmj without ""
		

		c. It'll return an access & refresh-token
		;; => {"access_token" 
		"ya29.A0AfH6SMC2sTfsOHTvxXKSomeAccessToken", 
		"expires_in" 3599, 
		"refresh_token" 
		"1//0RefreshAGBASNwF-L9IrTokenw6-9ParehereZ5EN", 
		"scope" "https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/spreadsheets", 
		"token_type" "Bearer"}
		
	4. Copy the access token & refresh token into gcreds-w-token
	5. Use   (def services (google-apps-clj.google-sheets-v4/build-service gcreds-w-token))    to connect to google sheets


Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
