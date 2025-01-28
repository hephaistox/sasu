(ns kotws.pages.c-about
  (:require
   [kotws.fe-language   :as kfe-lang]
   [kotws.pages.v-about :refer [v-about]]))

(defn about [] (v-about (kfe-lang/current-language)))
