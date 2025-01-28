(ns kotws.pages.c-it
  "Developper panel."
  (:require
   [kotws.fe-language :as kfe-lang]
   [kotws.pages.v-it  :as kit]))

(defn it [] (kit/v-it (kfe-lang/current-language)))
