(ns kotws.pages.c-biblio
  (:require
   [kotws.components.c-selector :as kcselector]
   [kotws.fe-language           :as kfe-lang]
   [kotws.pages.v-biblio        :as kvbiblio]))

(defn biblio
  []
  [kvbiblio/v-biblio
   (kfe-lang/current-language)
   (kcselector/selected :biblio-book)
   (partial kcselector/opts-go-to :biblio-book)
   (partial kcselector/opts-go-rel :biblio-book)])
