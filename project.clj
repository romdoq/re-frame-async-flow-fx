(defproject re-frame-async-flow-fx "0.0.1"
  :description  "A re-frame effects handler for coordinating async control flow. (Which often happens on app startup.)"
  :url          "https://github.com/Day8/re-frame-async-flow-fx.git"
  :license      {:name "MIT"}
  :dependencies [[org.clojure/clojure        "1.8.0"]
                 [org.clojure/clojurescript  "1.9.89"]
                 [reagent                    "0.6.0-rc"]
                 [re-frame                   "0.8.0-alpha1"]]

  :profiles {:debug {:debug true}
             :dev   {:dependencies [
                                    [karma-reporter     "0.3.0"]
                                    [binaryage/devtools "0.7.2"]]
                     :plugins      [[lein-cljsbuild "1.1.3"]
                                    [lein-npm       "0.6.2"]
                                    [lein-figwheel "0.5.4-5"]]}}

  :clean-targets [:target-path
                  "run/compiled"]

  :resource-paths ["run/resources"]
  :jvm-opts       ["-Xmx1g" "-XX:+UseConcMarkSweepGC"]
  :source-paths   ["src"]
  :test-paths     ["test"]
  :deploy-repositories [["releases" :clojars {:sign-releases false}]
                        ["snapshots" :clojars {:sign-releases false}]]

  :npm {:dependencies [[karma "1.0.0"]
                       [karma-cljs-test "0.1.0"]
                       [karma-chrome-launcher "0.2.0"]
                       [karma-junit-reporter "0.3.8"]]}

  :cljsbuild {:builds [{:id           "test"
                        :source-paths ["test" "src"]
                        :compiler     {:output-to     "run/compiled/test.js"
                                       :source-map    "run/compiled/test.js.map"
                                       :output-dir    "run/compiled/test"
                                       :optimizations :whitespace
                                       :main          "re-frame_async_flow_fx.test-runner"
                                       :pretty-print  true}}]}

  :aliases {"auto"        ["do" "clean," "cljsbuild" "auto" "test,"]
            "once"        ["do" "clean," "cljsbuild" "once" "test,"]})
