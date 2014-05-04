(ns oidp.test.schema
 (:use clojure.test
       ring.mock.request
       digest
       [oidp.models.schema :as db]))

(deftest test-get-users
  (testing "can select users"
    (is (vector? (db/get-users)))))

(deftest test-encrypt
  (testing "returns hashed string"
    (is (= (digest/sha-256 "hello") (db/hashify "hello")))))
