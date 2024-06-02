create table metrics
(
    id               bigint primary key generated always as identity,
    author           varchar not null,
    publications_num bigint,
    citations_num    bigint,
    calculation_date date not null
);