With customerDetails AS( select cu.contact_name, count(o.order_id) from public.orders o
    join public.customers cu on cu.customer_id = o.customer_id
    group by cu.contact_name
    order by count(o.order_id) desc)Select cd.contact_name From customerDetails cd
limit 1;