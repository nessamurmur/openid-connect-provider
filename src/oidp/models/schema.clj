(ns oidp.models.schema
  (:use [korma core db])
  (:require [config.migrate-config :as config]
            digest))

(defdb devdb config/db)

(defentity users)

(defn hashify [string]
  (digest/sha-256 string))

(defn get-users []
  (select users))

(defn login-user [username password]
  (select users
          (where (and
                  (:username username)
                  (:password (hashify password))))))
