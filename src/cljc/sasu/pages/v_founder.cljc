(ns sasu.pages.v-founder
  (:require
   [auto-web.components.v-headered-list :as wvheadered-list]
   [sasu.links                          :as slinks]))

(def dic
  {:founder {:fr "Fondateur"
             :en "Founder"}
   :first {:fr "Introduction"
           :en "Introduction"}
   :intro
   {:en
    "I have always been driven by an entrepreneurial spirit, surely a legacy from my parents who were traders. I finally created my company SASU Caumond in 2021 and founded the Hephaistox brand in 2023."
    :fr
    "J'ai toujours été animé d'un esprit d'entrepenariat, sûremenent un héritage de mes parents commerçants. J'ai finalement créé mon Entreprise SASU Caumond en 2021 et fondé la marque Hephaistox en 2023."}
   :first-desc {:fr "J'y vais ou j'y vais pas?"
                :en "Go / nogo?"}
   :first-long-desc
   {:fr
    "Je me suis posé la question de créer une entreprise à la fin de mon doctorat, mais je n'avais pas toutes les compétences, ni les connaissances. J'ai donc préféré intégrer une Entrerprise comme Michelin qui m'a permis de découvrir de nombreux domaines différents, tout en étant intégré dans l'Industrie."
    :en
    "I was wondering if I wouldn't create an enterprise at the end of my PhD. But I didn't have the necessary skills or knowledge. I've preferred to integrate an enterprise such as Michelin where I've discovered a lot of different aspects, while I was integrated in that industry not an external consultant."}
   :attempts {:fr "Tentatives"
              :en "Attempts"}
   :attempts-desc {:fr "Quelques faux départs"
                   :en "Some false starts"}
   :attempts-long-desc
   {:fr
    "J'ai tenté de développer des idées, des entreprises: le site commerçant de bijouterie, une application pour maîtriser à distance de la diaspora africaine. Je ne les vois pas comme des échecs mais des expériences qui m'ont permis d'apprendre. De plus, savoir arrêter un projet peut être une bonne chose."
    :en
    "I tried to develop ideas, businesses: the jewelry store website, an application to remotely control the African diaspora. I don't see them as failures but experiences that allowed me to learn. Moreover, knowing how to stop a project can be a good thing."}
   :hephaistox {:fr "Hephaistox"
                :en "Hephaistox"}
   :hephaistox-desc {:fr "Intégrer mes compétences"
                     :en "Integrate my skills"}
   :hephaistox-long-desc
   {:fr
    "Avec mati, j'ai co-fondé Hephaistox et c'est un point d'orgue dans ma carrière, une façon de tout assembler, donner du sens. Je pense mon expérience assez unique et je crois que je peux faire des belles choses avec ces connaissances."
    :en
    "With mati, I've co-founded Hephaistox and it's a high point in my career, a way to put everything together, to give meaning. I think my experience is quite unique and I believe I can do great things with this knowledge."}})

(def items
  [{:img-url :gonogo
    :founder-name :first}
   {:img-url :falsestart
    :founder-name :attempts}
   {:founder-name :hephaistox}])

(defn v-founder
  [l]
  (let [tr #(get-in dic [% l])
        tr-s (fn [l suffix] (tr (keyword (str (name l) "-" suffix))))
        founder-steps (->> items
                           (mapv (fn [{:keys [img-url founder-name]}]
                                   {:label (tr founder-name)
                                    :img-url (slinks/image-link (or img-url founder-name))
                                    :href (slinks/external-link founder-name)
                                    :desc (tr-s founder-name "desc")
                                    :long-desc (tr-s founder-name "long-desc")})))]
    [:<>
     [:h1.text (tr :founder)]
     [:div.text (tr :intro)]
     [wvheadered-list/detailed-list founder-steps :small]]))
