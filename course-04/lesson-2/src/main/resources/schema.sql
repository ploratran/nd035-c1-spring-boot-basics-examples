-- Create table for Candy
-- fields: id, name, price
create table if not exists candy (
    id bigint not null,
    name nvarchar(255),
    price double(10, 3),
    primary key (id)
);

-- Create a Mapping table (M-2-M relationship)
-- that can be used to add candy to our deliveries
--should have a column for both candy_id and delivery_id:
create table if not exists candy_delivery (
    candy_id bigint not null,
    delivery_id bigint not null
);