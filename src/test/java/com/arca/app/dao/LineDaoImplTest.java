package com.arca.app.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.util.UUID;

public class LineDaoImplTest {

    private static final String COLLECTION_NAME = "arcaFile";

    MongodForTestsFactory factory;
    MongoClient mongo;

    private LineDaoImpl lineDao;

    @Before
    public void setUp () throws IOException {
        factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
        mongo = factory.newMongo();
        DB db = mongo.getDB("test-" + UUID.randomUUID());
    }

    @After
    public void teardown() throws Exception {
        if (factory != null)
            factory.shutdown();
    }
}
