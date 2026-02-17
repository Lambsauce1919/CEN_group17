INSERT INTO users (id, name) VALUES (1, 'User 1')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO wishlists (id, name, users_id) VALUES (1, 'Want to Buy', 1)
    ON CONFLICT (id) DO NOTHING;