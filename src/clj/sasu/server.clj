(ns sasu.server
  "Server main entry main entry point."
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [sasu.handler       :refer [handler]])
  (:gen-class))

(defn -main
  "The `port` environment variable is could be used to change the port."
  [& _]
  (let [port (Integer/parseInt (or (System/getenv "port") "8080"))]
    (println "start HTTP webserver on port:" port)
    (run-jetty #'handler
               {:port port
                :join? false})))

(comment
  (-main)
  ;
)
