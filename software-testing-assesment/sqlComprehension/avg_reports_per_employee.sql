select avg(reports_to) as AvgReportsTo from public.employees;
select count(*) as AboveAvgReportsTo from public.employees
where reports_to > (select avg(reports_to) as AvgReportsTo from public.employees);