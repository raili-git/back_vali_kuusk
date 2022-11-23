INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Lääne-Virumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Raplamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Pärnumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Saaremaa');

INSERT INTO public.delivery (id, type, price) VALUES (DEFAULT, 'pickup', 0);
INSERT INTO public.delivery (id, type, price) VALUES (DEFAULT, 'courier', 15);

INSERT INTO public.height (id, gap) VALUES (DEFAULT, '0 kuni 1m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '1,1 kuni 1,5m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '1,6 kuni 2m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '2,1 kuni 2,5m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '2,6 kuni 3m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '3,1 kuni 4m');
INSERT INTO public.height (id, gap) VALUES (DEFAULT, '4,1 kuni 5m');

INSERT INTO public.role (id, type) VALUES (DEFAULT, 'seller');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');

INSERT INTO public.type (id, name) VALUES (DEFAULT, 'Kuusk');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'Nulg');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'Mänd');



