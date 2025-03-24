(ns jar
  "Creates an uberjar"
  (:require
   [clojure.edn             :as edn]
   [clojure.tools.build.api :as b]))

(def deps-file "deps.edn")

(defn basis "Create" [] (b/create-basis {:project deps-file}))

(defn clean [d] (b/delete {:path d}))

(defn edn-content
  [filename]
  (-> filename
      slurp
      edn/read-string))

(defn uber
  [{:keys [jarname root-dir production-dir class-dir]}]
  (let [uber-file (str production-dir "/" jarname)
        basis (basis)]
    (clean root-dir)
    (b/copy-dir {:src-dirs (-> deps-file
                               edn-content
                               :paths)
                 :target-dir class-dir})
    (b/compile-clj {:basis basis
                    :ns-compile '[sasu.server]
                    :class-dir class-dir})
    (b/uber {:class-dir class-dir
             :uber-file uber-file
             :basis basis
             :main 'sasu.server})))
