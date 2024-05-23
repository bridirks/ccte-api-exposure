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

create table ep.v_puc
(
    id         bigint not null
        constraint puc_pkey
            primary key,
    kind_name  varchar(50),
    gen_cat    varchar(50),
    prodfam    varchar(50),
    prodtype   varchar(100),
    definition text
);

create table ep.v_demo_expo_predictions
(
    id          serial
        constraint pk_v_demo_expo_predictions
            primary key,
    dtxsid      varchar(20),
    demographic varchar(25),
    predictor   varchar(25),
    median      double precision,
    l95         double precision,
    u95         double precision,
    units       varchar(20),
    ad          integer,
    reference   varchar(20),
    import_date timestamp default now()
);

create table ep.v_functional_use_category
(
    id            integer,
    created_at    timestamp,
    updated_at    timestamp,
    title         varchar(100),
    description   text,
    created_by_id integer,
    updated_by_id integer
);

create table ep.v_functional_use
(
    id               bigint,
    dtxsid           varchar(50),
    datatype         varchar(50),
    docid            integer,
    doctitle         varchar(500),
    docdate          varchar(25),
    reportedfunction varchar(255),
    functioncategory varchar(100)
);





