(ns sasu.handler
  "Backend handler to serve html files or resources."
  (:require
   [auto-web.request   :refer [match-lang-request]]
   [clojure.java.io    :as io]
   [reitit.ring        :as rring]
   [ring.util.response :as rr]))

(def index
  {"en" (slurp (io/resource "public/index_en.html"))
   "fr" (slurp (io/resource "public/index_fr.html"))})

(defn page-request
  [default-language page-by-language]
  (fn [request]
    (let [selected-lang (match-lang-request request (set (keys page-by-language)))]
      (-> (or selected-lang default-language)
          page-by-language
          rr/response
          (rr/update-header "cache-control" (fn [_] "max-age=0, private, must-revalidate"))
          (rr/content-type "text/html")))))

(def handler
  (rring/ring-handler (rring/router [["/ping"
                                      (constantly (-> "pong"
                                                      rr/response
                                                      (rr/content-type "text/plain")))]
                                     ["/index.html" (page-request "fr" index)]])
                      (rring/routes (rring/create-resource-handler {:path "/"})
                                    (rring/create-default-handler {:not-found
                                                                   (page-request "fr" index)}))))
