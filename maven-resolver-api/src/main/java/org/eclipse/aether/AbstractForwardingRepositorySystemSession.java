package org.eclipse.aether;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Map;

import org.eclipse.aether.artifact.ArtifactTypeRegistry;
import org.eclipse.aether.collection.DependencyGraphTransformer;
import org.eclipse.aether.collection.DependencyManager;
import org.eclipse.aether.collection.DependencySelector;
import org.eclipse.aether.collection.DependencyTraverser;
import org.eclipse.aether.collection.VersionFilter;
import org.eclipse.aether.repository.AuthenticationSelector;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.LocalRepositoryManager;
import org.eclipse.aether.repository.MirrorSelector;
import org.eclipse.aether.repository.ProxySelector;
import org.eclipse.aether.repository.WorkspaceReader;
import org.eclipse.aether.resolution.ArtifactDescriptorPolicy;
import org.eclipse.aether.resolution.ResolutionErrorPolicy;
import org.eclipse.aether.transfer.TransferListener;

/**
 * A special repository system session to enable decorating or proxying another session. To do so, clients have to
 * create a subclass and implement {@link #getSession()}.
 */
public abstract class AbstractForwardingRepositorySystemSession
    implements RepositorySystemSession
{

    /**
     * Creates a new forwarding session.
     */
    protected AbstractForwardingRepositorySystemSession()
    {
    }

    /**
     * Gets the repository system session to which this instance forwards calls. It's worth noting that this class does
     * not save/cache the returned reference but queries this method before each forwarding. Hence, the session
     * forwarded to may change over time or depending on the context (e.g. calling thread).
     * 
     * @return The repository system session to forward calls to, never {@code null}.
     */
    protected abstract RepositorySystemSession getSession();

    public boolean isOffline()
    {
        return getSession().isOffline();
    }

    public boolean isIgnoreArtifactDescriptorRepositories()
    {
        return getSession().isIgnoreArtifactDescriptorRepositories();
    }

    public ResolutionErrorPolicy getResolutionErrorPolicy()
    {
        return getSession().getResolutionErrorPolicy();
    }

    public ArtifactDescriptorPolicy getArtifactDescriptorPolicy()
    {
        return getSession().getArtifactDescriptorPolicy();
    }

    public String getChecksumPolicy()
    {
        return getSession().getChecksumPolicy();
    }

    public String getUpdatePolicy()
    {
        return getSession().getUpdatePolicy();
    }

    public LocalRepository getLocalRepository()
    {
        return getSession().getLocalRepository();
    }

    public LocalRepositoryManager getLocalRepositoryManager()
    {
        return getSession().getLocalRepositoryManager();
    }

    public WorkspaceReader getWorkspaceReader()
    {
        return getSession().getWorkspaceReader();
    }

    public RepositoryListener getRepositoryListener()
    {
        return getSession().getRepositoryListener();
    }

    public TransferListener getTransferListener()
    {
        return getSession().getTransferListener();
    }

    public Map<String, String> getSystemProperties()
    {
        return getSession().getSystemProperties();
    }

    public Map<String, String> getUserProperties()
    {
        return getSession().getUserProperties();
    }

    public Map<String, Object> getConfigProperties()
    {
        return getSession().getConfigProperties();
    }

    public MirrorSelector getMirrorSelector()
    {
        return getSession().getMirrorSelector();
    }

    public ProxySelector getProxySelector()
    {
        return getSession().getProxySelector();
    }

    public AuthenticationSelector getAuthenticationSelector()
    {
        return getSession().getAuthenticationSelector();
    }

    public ArtifactTypeRegistry getArtifactTypeRegistry()
    {
        return getSession().getArtifactTypeRegistry();
    }

    public DependencyTraverser getDependencyTraverser()
    {
        return getSession().getDependencyTraverser();
    }

    public DependencyManager getDependencyManager()
    {
        return getSession().getDependencyManager();
    }

    public DependencySelector getDependencySelector()
    {
        return getSession().getDependencySelector();
    }

    public VersionFilter getVersionFilter()
    {
        return getSession().getVersionFilter();
    }

    public DependencyGraphTransformer getDependencyGraphTransformer()
    {
        return getSession().getDependencyGraphTransformer();
    }

    public SessionData getData()
    {
        return getSession().getData();
    }

    public RepositoryCache getCache()
    {
        return getSession().getCache();
    }

}
