(ns sasu.fe-language
  "Frontend language."
  (:require
   [auto-web.local-storage :as wlocal-storage]
   [re-frame.core          :as rf]))

(rf/reg-sub ::language (fn [db _] (:language db)))

(rf/reg-event-db ::change-language (fn [db [_ language]] (assoc db :language language)))

(defn current-language "Currently set language in the UI." [] @(rf/subscribe [::language]))

(defn set-language
  [l]
  (wlocal-storage/set-item! :lang (name l))
  (rf/dispatch [::change-language l]))
