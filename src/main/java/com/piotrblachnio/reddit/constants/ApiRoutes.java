package com.piotrblachnio.reddit.constants;

public class ApiRoutes {
    private static final String _versionPrefix = "/api/v1";

    public static class Auth {
        private static final String _prefix = _versionPrefix + "/auth";

        public static final String REGISTER = _prefix + "/register";
        public static final String LOGIN = _prefix + "/login";
        public static final String LOGOUT = _prefix + "/logout";
        public static final String REFRESH_TOKEN = _prefix + "/refresh-token";
        public static final String CONFIRM_EMAIL = _prefix + "/confirm-email/{token}";
    }

    public static class Comment {
        private static final String _prefix = _versionPrefix + "/comment";

        public static final String CREATE = _prefix;
        public static final String GET_BY_POST = _prefix + "/by-post/{id}";
        public static final String GET_BY_USER = _prefix + "/by-user/{username}";
    }

    public static class Post {
        private static final String _prefix = _versionPrefix + "/post";

        public static final String CREATE = _prefix;
        public static final String GET_ALL = _prefix;
        public static final String GET_BY_ID = _prefix + "/{id}";
        public static final String GET_BY_SUBREDDIT = _prefix + "/by-subreddit/{id}";
        public static final String GET_BY_USER = _prefix + "/by-user/{username}";
    }

    public static class Subreddit {
        private static final String _prefix = _versionPrefix + "/subreddit";

        public static final String CREATE = _prefix;
        public static final String GET_ALL = _prefix;
        public static final String GET_BY_ID = _prefix + "/{id}";
    }

    public static class Vote {
        private static final String _prefix = _versionPrefix + "/vote";

        public static final String ADD = _prefix;
    }
}