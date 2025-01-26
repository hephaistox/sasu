(ns sasu.fe
  (:require
   [re-frame.core      :as rf]
   [reagent.dom.client :as rdomc]
   [sasu.active-panel  :refer [c-panel-el]]
   [sasu.db            :as db]
   [sasu.routes        :as routes]))

(rf/reg-event-db ::initialize-db (fn [_ _] db/default-db))

(defn mount-root
  []
  (rf/clear-subscription-cache!)
  (let [app-el (.getElementById js/document "body-div")]
    (-> (rdomc/create-root app-el)
        (rdomc/render [c-panel-el]))))

(defn- update-page [] (routes/setup!) (mount-root))

(defn refresh-page [] (js/console.log "Shadow refresh") (update-page))

(defn init
  []
  (js/console.log "Init frontend")
  ;; DB initialization should be done before `routes/setup!` so current
  ;; `url` can be turned into current route.
  (rf/dispatch-sync [::initialize-db])
  (update-page))
