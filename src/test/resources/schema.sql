-- create schema
create schema ep;

-- create tables

create table ep.v_product_data
(
    id                    bigint not null
        constraint product_data_pkey
            primary key,
    dtxsid                varchar(50),
    docid                 integer,
    doctitle              varchar(500),
    docdate               varchar(25),
    productname           varchar(255),
    gencat                varchar(50),
    prodfam               varchar(50),
    prodtype              varchar(100),
    classificationmethod  varchar(100),
    rawmincomp            varchar(100),
    rawmaxcomp            varchar(100),
    rawcentralcomp        varchar(100),
    unittype              varchar(50),
    lowerweightfraction   numeric(16, 15),
    upperweightfraction   numeric(16, 15),
    centralweightfraction numeric(16, 15),
    weightfractiontype    varchar(50),
    component             varchar(200)
);