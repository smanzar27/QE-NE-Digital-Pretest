select 
a.employee_id as employee,
a.employee_name as employee_name,
c.employee_name as buddy_name,
b.employee_name as supervisor_name,
a.team_name as team_name
FROM employee a
left join employee b on a.supervisor_id = b.employee_id
left join employee c on a.buddy_id = c.employee_id
order by team_name
