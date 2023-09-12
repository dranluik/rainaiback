INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public.package_type (id, name, price) VALUES (DEFAULT, 'Full', 2500);
INSERT INTO public.package_type (id, name, price) VALUES (DEFAULT, 'Frontend', 1800);
INSERT INTO public.package_type (id, name, price) VALUES (DEFAULT, 'Backend', 1800);

INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (DEFAULT, 1, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (DEFAULT, 2, 1, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (DEFAULT, 2, 2, 'mari', '123', 'A');
INSERT INTO public."user" (id, role_id, package_type_id, username, password, status) VALUES (DEFAULT, 2, 3, 'tiit', '123', 'A');

INSERT INTO public.contact (id, user_id, first_name, last_name) VALUES (DEFAULT, 1, 'Admin', 'Boss');
INSERT INTO public.contact (id, user_id, first_name, last_name) VALUES (DEFAULT, 2, 'Rain', 'Tüür');
INSERT INTO public.contact (id, user_id, first_name, last_name) VALUES (DEFAULT, 3, 'Mari', 'Nurme');
INSERT INTO public.contact (id, user_id, first_name, last_name) VALUES (DEFAULT, 4, 'Tiit', 'Priit');


INSERT INTO public.technology (id, package_type_id, name, status) VALUES (DEFAULT, 2, 'Vue', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (DEFAULT, 2, 'React', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (DEFAULT, 3, 'SQL', 'A');
INSERT INTO public.technology (id, package_type_id, name, status) VALUES (DEFAULT, 3, 'Java', 'A');

INSERT INTO public.lesson (id, package_type_id, technology_id, name, content, status, sequence) VALUES (1, 2, 1, 'Uue projekti loomine', null, 'A', null);
INSERT INTO public.lesson (id, package_type_id, technology_id, name, content, status, sequence) VALUES (2, 3, 2, 'Controller', null, 'A', null);
