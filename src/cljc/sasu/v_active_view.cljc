(ns sasu.v-active-view
  (:require
   [auto-web.components.v-labelled-image :as wvlabelled-image]
   [auto-web.components.v-lang           :as wvlang]
   [auto-web.components.v-lists          :as wvlists]
   [auto-web.components.v-space          :as wvspace]
   [sasu.links                           :as slinks]
   [sasu.pages                           :as spages]))

(def dic
  {:powered-by {:en "Powered by"
                :fr "Propulsé par"}
   :see-on-gh {:en "See the code"
               :fr "Voir le code"}
   :about {:en "About"
           :fr "A propos"}
   :biblio {:en "Bibliography"
            :fr "Bibliographie"}
   :contact {:en "Contacts"
             :fr "Contacts"}
   :cv-item {:en "Resume"
             :fr "CV"}
   :founder {:en "Founder"
             :fr "Fondateur"}
   :it {:en "I.T."
        :fr "Informatique"}
   :or {:en "Operations Research"
        :fr "Recherche opérationnelle"}
   :sc {:en "Industry / Supply Chain"
        :fr "Industrie / Chaîne logistique"}
   :this-website {:en "This website"
                  :fr "Ce site"}
   :content-title {:en "Contents"
                   :fr "Contenus"}
   :teaching {:en "Teaching"
              :fr "Enseignement"}
   :home {:en "Home"
          :fr "Accueil"}
   :tech-stack {:en "Tech stack"
                :fr "Stack technique"}
   :rights-assertion {:en "All rights reserved"
                      :fr "Tous droits réservés"}})

(defn v-footer
  [l year size]
  (let [tr #(get-in dic [% l])]
    [:footer.w3-row.secondary-bg.w3-display-container.secondary-text.adaptative.w3-center
     {:style {:height size
              :min-height "10em"}}
     [:div.w3-right
      [wvlabelled-image/raw-image
       (slinks/image-link :git-hub)
       (slinks/external-link :sasu-caumond)
       (tr :see-on-gh)
       :small]]
     [:div.w3-display-bottommiddle
      [:div (str "Copyright © " year " Caumond - ") (tr :rights-assertion)]
      [:div " "]
      [:div (tr :powered-by) " " [slinks/a :w3-css "w3.css"]]]]))

(defn v-header
  [current-language switch-lang size]
  [:header.w3-bar.w3-row {:style {:height size
                                  :min-height "3em"}}
   [wvlang/lang-bar #{:fr :en} current-language switch-lang]])

(defn v-left
  [l]
  (let [tr #(get-in dic [% l])
        categories (->> [{:fa-icon "fa-diamond"
                          :label :founder
                          :href :founder}
                         {:fa-icon "fa-code"
                          :label :it
                          :href :it}
                         {:fa-icon "fa-calculator"
                          :label :or
                          :href :or}
                         {:fa-icon "fa-industry"
                          :label :sc
                          :href :sc}]
                        (map #(-> %
                                  (update :href slinks/route-link)
                                  (update :label tr))))
        menus (->> (filter :menu? spages/pages)
                   (map (fn [link]
                          {:href (update link :href slinks/route-link)
                           :label (tr (:name link))})))
        social (->> [{:fa-icon "fa-linkedin"
                      :href :linkedin
                      :label "Linkedin"}
                     {:fa-icon "fa-envelope-open"
                      :href {:url "mailto:anthony@caumond.com"}
                      :label "Mail"}
                     {:fa-icon "fa-slack"
                      :href :slack
                      :label "Slack"}
                     {:fa-icon "fa-github"
                      :href :git-hub
                      :label "Github"}]
                    (map #(-> %
                              (update :href slinks/external-link)
                              (update :label tr))))
        header-image (-> {:fr {:img-link :anthony
                               :href-link :home}
                          :en {:img-link :sasu-caumond
                               :href-link :home}}
                         (update-vals #(-> %
                                           (update :img-link slinks/image-link)
                                           (update :href-link slinks/route-link))))
        header-image-dark (-> {:fr {:img-link :anthony
                                    :href-link :home}
                               :en {:img-link :sasu-caumond-dark
                                    :href-link :home}}
                              (update-vals #(-> %
                                                (update :img-link slinks/image-link)
                                                (update :href-link slinks/route-link))))]
    [:<>
     [:span.adaptative.hidden-dark [wvlang/vclabelled-rounded-image l header-image nil :full]]
     [:span.adaptative.hidden-light [wvlang/vclabelled-rounded-image l header-image-dark nil :full]]
     [:div.w3-left-align
      [wvlists/one-per-row "Anthony CAUMOND" categories]
      [wvlists/small-buttons (tr :contact) social]
      [wvlists/one-per-row (tr :content-title) menus]
      [wvspace/vertical-spacing]]]))
