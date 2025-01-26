(ns sasu.db
  "Default database values."
  (:require
   [auto-web.lang :as wl]))

(def default-db
  {:name "Anthony CAUMOND professional website"
   :selected-items #{}
   :language (wl/page-language)
   :active-panel nil
   :slide-idx 0})
