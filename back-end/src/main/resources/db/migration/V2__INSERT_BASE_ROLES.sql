INSERT INTO authority(id, authority)
SELECT 1, 'ROLE_JOB_SEEKER'
WHERE
NOT EXISTS (
    SELECT id FROM authority WHERE authority = 'ROLE_JOB_SEEKER'
);
INSERT INTO authority(id, authority)
SELECT 2, 'ROLE_EMPLOYER'
    WHERE
NOT EXISTS (
    SELECT id FROM authority WHERE authority = 'ROLE_EMPLOYER'
);