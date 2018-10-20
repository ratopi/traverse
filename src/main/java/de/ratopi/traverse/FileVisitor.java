package de.ratopi.traverse;

import java.io.File;

/**
 * The FileVisitor is called for each file and directory in the file tree.
 */
public interface FileVisitor
{
	/**
	 * Is called for each file and directory in the file tree.
	 * @param file A file out of the file tree
	 */
	public void visit( File file);
}
