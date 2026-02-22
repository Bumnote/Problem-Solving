select a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from PATIENT p 
join APPOINTMENT a on p.pt_no = a.pt_no
join DOCTOR d on d.dr_id = a.mddr_id
where a.mcdp_cd = "CS" and date_format(a.apnt_ymd, "%Y-%m-%d") = "2022-04-13" and a.apnt_cncl_yn = "N"
order by a.apnt_ymd;