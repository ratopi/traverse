package de.ratopi.traverse;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class TraverseTest
{
	@Test
	public void test_found()
	{
		final Traverse traverse = new Traverse();

		final FindByNameFileVisitor fileVisitor = new FindByNameFileVisitor( "Traverse.java" );
		traverse.traverse( new File( "." ), fileVisitor );

		Assert.assertEquals( 1, fileVisitor.getFiles().size() );
	}

	@Test
	public void test_not_found()
	{
		final Traverse traverse = new Traverse();

		final FindByNameFileVisitor fileVisitor = new FindByNameFileVisitor( "This file does not exist" );
		traverse.traverse( new File( "." ), fileVisitor );

		Assert.assertEquals( 0, fileVisitor.getFiles().size() );
	}
}
