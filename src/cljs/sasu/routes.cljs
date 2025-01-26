(ns sasu.routes
  "Frontend routing"
  (:require
   [re-frame.core        :as rf]
   [reitit.frontend      :as rfe]
   [reitit.frontend.easy :as rfe-ez]
   [sasu.pages           :as spages]))

(rf/reg-event-db ::set-active-panel
                 (fn [db [_ active-panel]] (assoc db :active-panel active-panel)))

(defn on-navigate
  "Called when the uri is modified by browser integeration."
  [match _history]
  (rf/dispatch-sync [::set-active-panel
                     (-> match
                         (get-in [:data :name]))]))

(defn setup!
  []
  (-> (mapv (juxt :uri :name) spages/pages)
      rfe/router
      (rfe-ez/start! on-navigate {})))
