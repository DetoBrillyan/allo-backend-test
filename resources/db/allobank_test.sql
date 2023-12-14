/*
 Navicat Premium Data Transfer

 Source Server         : postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 120010
 Source Host           : localhost:5432
 Source Catalog        : allobank
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120010
 File Encoding         : 65001

 Date: 14/12/2023 10:05:42
*/


-- ----------------------------
-- Table structure for caleg
-- ----------------------------
DROP TABLE IF EXISTS "public"."caleg";
CREATE TABLE "public"."caleg" (
  "id" uuid NOT NULL,
  "jenis_kelamin" int2,
  "nama" varchar(255) COLLATE "pg_catalog"."default",
  "nomor_urut" int4,
  "dapil_id" uuid,
  "partai_id" uuid
)
;

-- ----------------------------
-- Records of caleg
-- ----------------------------
INSERT INTO "public"."caleg" VALUES ('61949d68-eee4-449b-82ae-7e1bc0f0ecf7', 0, 'Deto Brillyan', 1, '61949d68-eee4-449b-82ae-7e1bc0f0ecf7', '61949d68-eee4-449b-82ae-7e1bc0f0ecf7');
INSERT INTO "public"."caleg" VALUES ('09789718-269a-45ed-a70a-fa4431f5ec11', 1, 'Lisna', 2, '09789718-269a-45ed-a70a-fa4431f5ec11', '09789718-269a-45ed-a70a-fa4431f5ec11');
INSERT INTO "public"."caleg" VALUES ('013ba1d9-1a81-48b8-8508-191912f57c5b', 1, 'Dinda', 2, '681bd348-3971-4850-b9e2-d132002fddc7', 'd818dd2b-b8b0-44e9-8729-3b0d854e06cf');

-- ----------------------------
-- Table structure for dapil
-- ----------------------------
DROP TABLE IF EXISTS "public"."dapil";
CREATE TABLE "public"."dapil" (
  "id" uuid NOT NULL,
  "jumlah_kursi" int4 NOT NULL,
  "nama_dapil" varchar(255) COLLATE "pg_catalog"."default",
  "provinsi" varchar(255) COLLATE "pg_catalog"."default",
  "wilayah_dapil_list" varchar(255)[] COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of dapil
-- ----------------------------
INSERT INTO "public"."dapil" VALUES ('09789718-269a-45ed-a70a-fa4431f5ec11', 1, 'DKI1', 'DKI', '{DKI}');
INSERT INTO "public"."dapil" VALUES ('61949d68-eee4-449b-82ae-7e1bc0f0ecf7', 1, ' BGR1', 'jawabrat', '{Bogor}');
INSERT INTO "public"."dapil" VALUES ('681bd348-3971-4850-b9e2-d132002fddc7', 1, 'BGR2', 'Jawabarat', '{"Bogor BArat"}');

-- ----------------------------
-- Table structure for partai
-- ----------------------------
DROP TABLE IF EXISTS "public"."partai";
CREATE TABLE "public"."partai" (
  "id" uuid NOT NULL,
  "nama_partai" varchar(255) COLLATE "pg_catalog"."default",
  "nomor_urut" int4
)
;

-- ----------------------------
-- Records of partai
-- ----------------------------
INSERT INTO "public"."partai" VALUES ('61949d68-eee4-449b-82ae-7e1bc0f0ecf7', 'PARTAI JUARA', 1);
INSERT INTO "public"."partai" VALUES ('09789718-269a-45ed-a70a-fa4431f5ec11', 'PARTAi BERSAMA', 2);
INSERT INTO "public"."partai" VALUES ('d818dd2b-b8b0-44e9-8729-3b0d854e06cf', 'PARTAI SEMANGAT', 3);

-- ----------------------------
-- Checks structure for table caleg
-- ----------------------------
ALTER TABLE "public"."caleg" ADD CONSTRAINT "caleg_jenis_kelamin_check" CHECK (jenis_kelamin >= 0 AND jenis_kelamin <= 1);

-- ----------------------------
-- Primary Key structure for table caleg
-- ----------------------------
ALTER TABLE "public"."caleg" ADD CONSTRAINT "caleg_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table dapil
-- ----------------------------
ALTER TABLE "public"."dapil" ADD CONSTRAINT "dapil_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table partai
-- ----------------------------
ALTER TABLE "public"."partai" ADD CONSTRAINT "partai_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table caleg
-- ----------------------------
ALTER TABLE "public"."caleg" ADD CONSTRAINT "fkjm3utxjucqou32awtddbgmyxq" FOREIGN KEY ("dapil_id") REFERENCES "public"."dapil" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."caleg" ADD CONSTRAINT "fkoh8t8idintw81fo165q461taq" FOREIGN KEY ("partai_id") REFERENCES "public"."partai" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
