(ns sasu.pages "Declare here all frontend pages. Check also the routes of the frontend technology.")

(def pages
  (->>
    [{:uri "/"
      :name :home
      :fa-icon "fa-home"
      :menu? true}
     {:uri "/biblio"
      :name :biblio
      :fa-icon "fa-book"
      :menu? true}
     {:uri "/tech-stack"
      :name :tech-stack
      :fa-icon "fa-bullhorn"
      :menu? true}
     {:uri "/founder"
      :name :founder}
     {:uri "/it"
      :name :it}
     {:uri "/or"
      :name :or}
     {:uri "/sc"
      :name :sc}
     {:uri "/teaching"
      :name :teaching
      :menu? true
      :fa-icon "fa-university"}
     {:uri "/this-website"
      :name :this-website
      :menu? true
      :fa-icon "fa-globe"}
     {:fa-icon "fa-user"
      :name :about
      :uri "/about"
      :menu? true}]
    (mapv (fn [{:keys [uri]
                :as page}]
            (assoc page :url (str "#" uri))))))
