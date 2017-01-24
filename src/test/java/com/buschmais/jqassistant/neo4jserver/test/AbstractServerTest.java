package com.buschmais.jqassistant.neo4jserver.test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;

import com.buschmais.jqassistant.core.store.impl.EmbeddedGraphStore;
import com.buschmais.jqassistant.neo4jserver.api.Server;
import com.buschmais.jqassistant.neo4jserver.impl.ExtendedCommunityNeoServer;
import com.buschmais.jqassistant.plugin.common.test.AbstractPluginIT;


/**
 * Abstract base class for server tests.
 */
public class AbstractServerTest extends AbstractPluginIT {

    public static final int SERVER_PORT = 17474;

    private Server server;

    @Before
    public void startServer() throws IOException {
        EmbeddedGraphStore embeddedGraphStore = (EmbeddedGraphStore) store;
        server = new ExtendedCommunityNeoServer(embeddedGraphStore, ExtendedCommunityNeoServer.DEFAULT_ADDRESS, SERVER_PORT);
        server.start();
    }

    @After
    public void stopServer() {
        server.stop();
    }
}
