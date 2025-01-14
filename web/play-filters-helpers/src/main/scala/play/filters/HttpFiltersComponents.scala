/*
 * Copyright (C) from 2022 The Play Framework Contributors <https://github.com/playframework>, 2011-2021 Lightbend Inc. <https://www.lightbend.com>
 */

package play.filters

import play.api.mvc.EssentialFilter
import play.filters.csrf.CSRFComponents
import play.filters.headers.SecurityHeadersComponents
import play.filters.hosts.AllowedHostsComponents

/**
 * A compile time default filters components.
 *
 * {{{
 * class MyComponents(context: ApplicationLoader.Context)
 *   extends BuiltInComponentsFromContext(context)
 *   with play.filters.HttpFiltersComponents {
 *
 * }
 * }}}
 */
trait HttpFiltersComponents extends CSRFComponents with SecurityHeadersComponents with AllowedHostsComponents {
  def httpFilters: Seq[EssentialFilter] = Seq(csrfFilter, securityHeadersFilter, allowedHostsFilter)
}
