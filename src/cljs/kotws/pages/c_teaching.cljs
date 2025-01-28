(ns kotws.pages.c-teaching
  (:require
   [kotws.fe-language      :as kfe-lang]
   [kotws.pages.v-teaching :refer [v-teaching]]))

(defn teaching [] (v-teaching (kfe-lang/current-language)))
