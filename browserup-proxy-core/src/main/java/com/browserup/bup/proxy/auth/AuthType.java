/*
 * Modifications Copyright (c) 2019 BrowserUp, Inc.
 */

package com.browserup.bup.proxy.auth;

/**
 * Authentication types support by BrowserUpProxy.
 */
public enum AuthType {
    BASIC,
    // TODO: determine if we can actually do NTLM authentication
    NTLM
}
