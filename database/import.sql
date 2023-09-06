INSERT INTO public.role (id, name) VALUES (2, 'customer');
INSERT INTO public.role (id, name) VALUES (1, 'admin');

INSERT INTO public.package_type (id, name, price) VALUES (1, 'full', 2500);
INSERT INTO public.package_type (id, name, price) VALUES (2, 'frontend', 1800);
INSERT INTO public.package_type (id, name, price) VALUES (3, 'backend', 1800);

INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (1, 1, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (2, 2, 1, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (3, 2, 2, 'mari', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (4, 2, 3, 'tiit', '123', 'A');

INSERT INTO public.technology (id, package_type_id, name, status) VALUES (1, 2, 'Vue', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (2, 2, 'React', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (3, 3, 'SQL', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (4, 3, 'Java', 'A');

INSERT INTO public.lesson (id, package_type_id, technology_id, name, content, status, sequence) VALUES (1, 2, 1, 'Uue projekti loomine', null, 'A', null);
