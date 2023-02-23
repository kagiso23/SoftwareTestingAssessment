select EXTRACT(YEAR FROM o.order_date),
count(o.order_id) from public.orders o
where EXTRACT(YEAR FROM o.order_date) >= 1996
group by EXTRACT(YEAR FROM o.order_date);