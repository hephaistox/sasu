(ns sasu.active-panel
  (:require
   [auto-web.components.v-space :as wvspace]
   [re-frame.core               :as rf]
   [sasu.c-pages                :as scpages]
   [sasu.fe-language            :as sfe-lang]
   [sasu.v-active-view          :as svapp-view]))

(rf/reg-sub ::active-panel (fn [db _] (:active-panel db)))

(defn c-panel-el
  []
  (let [active-panel @(rf/subscribe [::active-panel])
        home-panel (scpages/kw->panel :home)
        year (-> (js/Date.)
                 .getFullYear)
        l (sfe-lang/current-language)]
    [:<>
     [svapp-view/v-header l sfe-lang/set-language "7vh"]
     [:div.w3-row {:style {:max-width "1600px"
                           :min-height "76vh"}}
      [:div.w3-container.w3-quarter.left-menu [:div.w3-card [svapp-view/v-left l]]]
      [:div.w3-col.w3-hide-small.w3-hide-medium {:style {:width "4vw"}}
       [:p " "]]
      [:div.w3-rest.printable-content.w3-card.w3-container
       (or (scpages/kw->panel active-panel) home-panel)
       [wvspace/vertical-spacing]]]
     [wvspace/vh-spacing]
     [svapp-view/v-footer l year "15vh"]]))
