WITH frontend AS (
    SELECT SUM(code) AS FRONT_CODE
    FROM skillcodes
    WHERE category LIKE '%Front End%'
)
SELECT
    CASE
        WHEN (d.skill_code & f.FRONT_CODE) != 0 
             AND (d.skill_code & (SELECT code FROM skillcodes WHERE name = 'Python')) != 0 
             THEN 'A'
        WHEN (d.skill_code & (SELECT code FROM skillcodes WHERE name LIKE '%C#%')) != 0 
             THEN 'B'
        WHEN (d.skill_code & f.FRONT_CODE) != 0 
             THEN 'C'
    END AS GRADE,
    d.id AS ID,
    d.email AS EMAIL
FROM developers d, frontend f 
WHERE (
      (d.skill_code & f.FRONT_CODE) != 0
   OR (d.skill_code & (SELECT code FROM skillcodes WHERE name = 'Python')) != 0
   OR (d.skill_code & (SELECT code FROM skillcodes WHERE name LIKE '%C#%')) != 0
)
GROUP BY GRADE, d.id, d.email
HAVING GRADE IS NOT NULL
ORDER BY GRADE ASC, d.id ASC;