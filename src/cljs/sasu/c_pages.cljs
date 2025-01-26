(ns sasu.c-pages
  (:require
   [sasu.blogs.v-this-website :refer [v-this-website]]
   [sasu.fe-language          :refer [current-language]]
   [sasu.pages]
   [sasu.pages.c-biblio       :refer [c-biblio]]
   [sasu.pages.v-about        :refer [v-about]]
   [sasu.pages.v-founder      :refer [v-founder]]
   [sasu.pages.v-home         :refer [v-home]]
   [sasu.pages.v-it           :refer [v-it]]
   [sasu.pages.v-o-r          :refer [v-o-r]]
   [sasu.pages.v-sc           :refer [v-sc]]
   [sasu.pages.v-teaching     :refer [v-teaching]]
   [sasu.pages.v-tech-stack   :refer [c-tech-stack]]))

(defn kw->panel
  [kw]
  (case kw
    :about [v-about (current-language)]
    :biblio [c-biblio (current-language) :biblio-book]
    :it [v-it (current-language)]
    :founder [v-founder (current-language)]
    :home [v-home (current-language)]
    :or [v-o-r (current-language)]
    :sc [v-sc (current-language)]
    :this-website [v-this-website (current-language)]
    :teaching [v-teaching (current-language)]
    :tech-stack [c-tech-stack (current-language)]))

(def pages sasu.pages/pages)
