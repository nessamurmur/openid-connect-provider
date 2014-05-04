(ns migrations.001-create-users
  (:require [clojure.java.jdbc :as sql]
            [config.migrate-config :as config]))

(defn up
  "Creates users table"
  []
  (sql/with-connection config/db
    (sql/create-table
     :users
     [:id "varchar(32) PRIMARY KEY"]
     [:username "varchar(255) UNIQUE"]
     [:encrypted_password "varchar(255)"]
     [:create_at :timestamp]
     [:updated_at :timestamp])))

(defn down
  "Migrates the database down from version 1."
  []
  (sql/with-connection config/db
    (sql/drop-table :users)))
