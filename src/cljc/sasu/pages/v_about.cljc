(ns sasu.pages.v-about
  (:require
   [sasu.links :as slinks]))

(def siren "905156402")
(def siret "90515640200018")

(def dic
  {:about-title {:en "About"
                 :fr "A propos"}
   :introduce-sasu
   {:fr [:div
         [:p
          "Je suis travail indépendant - freelance, président de l'entreprise "
          [:span [slinks/a :sasu-societe "SASU CAUMOND (cf. societe.com)"]]
          ", SIREN: "
          siren
          ", SIRET:"
          siret
          "."]
         [:p
          "J'ai co-fondé "
          [slinks/a :hephaistox "Hephaistox"]
          " avec Mati (Mateusz Mazurczak) pour répondre aux besoins de chaîne logistique des PMIs."]
         [:h2 "Crédits"]
         [:ul
          [:li "Icones créées avec " [slinks/a :fontawesome "fontawesome"]]
          [:li "Icones créées avec Freepik - " [slinks/a :flaticon "Flaticon"]]]]
    :en [:div
         [:p
          "I am self-employed - freelance, president of the company "
          [:span [slinks/a :sasu-societe "SASU CAUMOND (cf. societe.com)"]]
          ", SIREN: "
          siren
          ", SIRET:"
          siret
          "."]
         [:p
          "I co-founded "
          [slinks/a :hephaistox "Hephaistox"]
          " with Mati (Mateusz Mazurczak) to meet the supply chain needs of SMEs."]
         [:h2 "Credits"]
         [:ul
          [:li "Icons created with " [slinks/a :fontawesome "fontawesome"]]
          [:li "Icons created with Freepik - " [slinks/a :flaticon "Flaticon"]]]]}})

(defn v-about
  [l]
  (let [tr #(get-in dic [% l])] [:<> [:h1.text "SASU CAUMOND"] [:div.text (tr :introduce-sasu)]]))
