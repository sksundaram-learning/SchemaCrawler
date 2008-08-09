/*
 * SchemaCrawler
 * Copyright (c) 2000-2008, Sualeh Fatehi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package schemacrawler.crawl;


import schemacrawler.schema.Column;
import schemacrawler.schema.DatabaseObject;
import schemacrawler.schema.Index;
import schemacrawler.schema.PrimaryKey;

/**
 * Represents a primary key in a table.
 * 
 * @author Sualeh Fatehi
 */
class MutablePrimaryKey
  extends MutableIndex
  implements PrimaryKey
{

  private static final long serialVersionUID = -7169206178562782087L;

  /**
   * Copies information from an index.
   * 
   * @param index
   *        Index
   */
  MutablePrimaryKey(final Index index)
  {
    super(index.getName(), index.getParent());
    setCardinality(index.getCardinality());
    setPages(index.getPages());
    setRemarks(index.getRemarks());
    setSortSequence(index.getSortSequence());
    setType(index.getType());
    setUnique(index.isUnique());
    // Copy columns
    for (final Column column: index.getColumns())
    {
      addColumn(column.getOrdinalPosition(), (MutableColumn) column);
    }
  }

  MutablePrimaryKey(final String name, final DatabaseObject parent)
  {
    super(name, parent);
  }

}
