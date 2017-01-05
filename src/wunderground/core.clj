(ns wunderground.core
  (:gen-class)
  (:require [org.httpkit.client :as client]
            [clojure.data.json :as json])
  )

(defn -main
  [& args]
  (println "Args were: " args)
  (def api-key "367af81f6daa0a7b")
  (def api-base-url "http://api.wunderground.com/api/")
  (def weather-query "/conditions/q/CA/94558.json")
  (def query-url (str api-base-url api-key weather-query))
  (prn 'URL  query-url)
                                        ;(def response (client/get query-url))
                                        ;(prn 'RESPONSE response)
  (client/get query-url
          (fn [{:keys [status headers body error]}] ;; asynchronous response handling
            (if error
              (println "Failed, exception is " error)
              (do
                (println "Async HTTP GET status: " status)
                                        ;(println "Async HTTP GET headers: " headers)
                                        ;(println "Async HTTP GET body: " body)
                (let [body-map (json/read-str body)]
                  (do
                                        ;(prn 'FROM_HTTP body)
                    (prn 'FROM_LIB body-map)
                    (println "\n\n")
                    (prn 'RESPONSE (get-in body-map [:response]))
                    (println "\n\n"))))))))
