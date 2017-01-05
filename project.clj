(defproject wunderground "0.1.0-SNAPSHOT"
  :description "Simple client for Wunderground API"
  :url "http://wunderground.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/data.json "0.2.6"]]
                                        ;[org.clojure/tools.nrepl "0.10.2"]]
  :plugins [[cider/cider-nrepl "0.14.0"]]
  :main ^:skip-aot wunderground.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
