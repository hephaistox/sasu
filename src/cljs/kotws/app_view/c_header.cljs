(ns kotws.app-view.c-header
  "Header of all pages."
  (:require
   [kotws.app-view.v-header :as kheader]
   [kotws.fe-language       :as kfe-lang]))

(defn c-header
  "Component displaying the header."
  [size]
  (kheader/v-header (kfe-lang/current-language) kfe-lang/set-language size))
