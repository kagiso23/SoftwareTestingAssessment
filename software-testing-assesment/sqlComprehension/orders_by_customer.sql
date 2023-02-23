select count(o.order_id) from public.orders o
left join public.customers cu on cu.customer_id = o.customer_id
left join public.shippers s on s.shipper_id = o.ship_via
where s.shipper_id = 2 and cu.contact_name = 'Simons bistro'