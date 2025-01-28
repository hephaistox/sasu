(ns kotws.routes
  "Frontend routing"
  (:require
   [kotws.events         :as ke]
   [kotws.pages          :as kpages]
   [re-frame.core        :as rf]
   [reitit.frontend      :as rfe]
   [reitit.frontend.easy :as rfe-ez]))

(defn on-navigate
  "Called when the uri is modified by browser integeration."
  [match _history]
  (rf/dispatch-sync [::ke/set-active-panel
                     (-> match
                         (get-in [:data :name]))]))

(defn setup!
  []
  (-> (mapv (juxt :uri :name) (vals kpages/pages))
      rfe/router
      (rfe-ez/start! on-navigate {})))
