(defproject wunderground "0.1.0-SNAPSHOT"
  :description "Simple client for Wunderground API"
  :url "http://wunderground.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-http "2.0.0" :as http]]
  :main ^:skip-aot wunderground.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
